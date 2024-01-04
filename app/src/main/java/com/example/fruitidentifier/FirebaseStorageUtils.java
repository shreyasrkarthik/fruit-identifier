package com.example.fruitidentifier;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.logging.Logger;

public class FirebaseStorageUtils {

    /**
     * Loads an image from Firebase Storage into the provided ImageView.
     *
     * @param context       The context calling this method.
     * @param storagePath   The path in Firebase Storage where the image is located.
     * @param imageView     The ImageView to load the image into.
     */
    public static void loadImageIntoView(Context context, String storagePath, ImageView imageView) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        StorageReference imageRef = storageRef.child(storagePath);
        Log.i("FirebaseStorageUtils", imageRef.getDownloadUrl().toString());
        imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(context)
                        .load(uri)
                        .into(imageView);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.e("FirebaseStorageUtils", "Error retrieving image", exception);
            }
        });
    }
}
