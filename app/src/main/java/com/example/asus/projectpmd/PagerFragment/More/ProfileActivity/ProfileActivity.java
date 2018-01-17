package com.example.asus.projectpmd.PagerFragment.More.ProfileActivity;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.projectpmd.MainActivity;
import com.example.asus.projectpmd.R;
import com.example.asus.projectpmd.db.SessionManager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {

    private ImageView profile;
    private SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sessionManager = new SessionManager(this);
        profile = (ImageView)findViewById(R.id.img_profil);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });

        if(!sessionManager.imageBitmap().equals("")){
            byte[] b = Base64.decode(sessionManager.imageBitmap(), Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            profile.setImageBitmap(bitmap);
        }
    }

    private void selectImage() {
        try {
            PackageManager pm = getPackageManager();
            int hasPerm = pm.checkPermission(Manifest.permission.CAMERA, getPackageName());

            if (hasPerm == PackageManager.PERMISSION_GRANTED) {
                final CharSequence[] options = {"Take Photo", "Choose From Gallery","Cancel"};
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (options[item].equals("Take Photo")) {
                            dialog.dismiss();
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, 1);
                        } else if (options[item].equals("Choose From Gallery")) {
                            dialog.dismiss();
                            Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            startActivityForResult(pickPhoto, 2);
                        } else if (options[item].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            } else {
                CheckPermission();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Camera Permission error", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            onCaptureImageResult(data);
        }
        else{
            onSelectFromGalleryResult(data);
        }
    }

    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        profile.setImageBitmap(bm);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if(bm!= null) {
            bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] b = baos.toByteArray();
            String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
            sessionManager.setImageBitmap(encodedImage);
        }
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        profile.setImageBitmap(thumbnail);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
        sessionManager.setImageBitmap(encodedImage);
    }

    private boolean CheckPermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE+Manifest.permission.WRITE_EXTERNAL_STORAGE+Manifest.permission.CAMERA);
        if(result== PackageManager.PERMISSION_GRANTED){
            return true;
        }else{
            RequestPermission();
            return false;
        }
    }

    private void RequestPermission() {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},2);
        }else if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},3);
        }
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, 1);
        }
    }


}
