package com.example.danielbastos.msn.Chat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.danielbastos.msn.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfileActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private Bitmap mImageBitmap;
    String mCurrentPhotoPath;
    ImageView userAvatar;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


        this.userAvatar = (ImageView) findViewById(R.id.viewA);

        editText = (EditText) findViewById(R.id.field_status);
    }

    public void tirarFoto(View v){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {


                Bitmap photo = (Bitmap) data.getExtras().get("data");

                File fotoDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                File fotoImg = new File(fotoDir,"foto" + System.currentTimeMillis() + ".jpg");


                Uri uri = Uri.fromFile(fotoImg);
                data.putExtra(MediaStore.EXTRA_OUTPUT, uri);

                userAvatar.setImageBitmap(photo);
                editText.setText(uri.toString());

            }
        }
    }
}
