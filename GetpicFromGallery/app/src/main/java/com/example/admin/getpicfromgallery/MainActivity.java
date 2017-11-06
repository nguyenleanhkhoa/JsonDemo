package com.example.admin.getpicfromgallery;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static android.net.Uri.parse;

public class MainActivity extends AppCompatActivity {
    Button btnenter;
    ArrayList<ImageHinh> imgpath;
    AdapterImage adapterImage;
    ListView listHinh;

    int PICK_IMAGE_MULTIPLE = 1;
    String imageEncoded;
    FirebaseStorage storage;
    StorageReference storageRef;
    private static int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        addControl();
        addEvent();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE_MULTIPLE){

            if(resultCode==RESULT_OK){
                //data.getParcelableArrayExtra(name);
                //If Single image selected then it will fetch from Gallery
                if(data.getData()!=null){

                    Uri mImageUri=data.getData();

                }else{
                    if(data.getClipData()!=null){
                        ClipData mClipData=data.getClipData();
                        ArrayList<Uri> mArrayUri=new ArrayList<Uri>();
                        for(int i=0;i<mClipData.getItemCount();i++){

                            ClipData.Item item = mClipData.getItemAt(i);
                            Uri uri = item.getUri();
                            mArrayUri.add(uri);
                            Log.v("LOG_TAG","path :"+mArrayUri.get(i));
                            ImageHinh imageHinh=new ImageHinh(mArrayUri.get(i).toString());
                            Toast.makeText(this, ""+imageHinh.getPicPath(), Toast.LENGTH_SHORT).show();
                            imgpath.add(imageHinh);


                            try {
                                Bitmap  bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);
                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                                byte[] data1 = baos.toByteArray();
                                StorageReference mountainsRef = storageRef.child("image_cmt_"+mArrayUri.get(i).toString());
                                UploadTask uploadTask = mountainsRef.putBytes(data1);

                                uploadTask.addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception exception) {
                                        // Handle unsuccessful uploads
                                        Toast.makeText(MainActivity.this, "Upload Failed!", Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
                                        Toast.makeText(MainActivity.this, "Upload Done!", Toast.LENGTH_SHORT).show();

                                    }
                                });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }



                        }
                        listHinh.setAdapter(adapterImage);
                        Log.v("LOG_TAG", "Selected Images"+ mArrayUri.size());
                    }

                }

            }

        }

    }

    private void addEvent() {
        btnenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"), PICK_IMAGE_MULTIPLE);
            }
        });
    }

    private void addControl() {
        listHinh=findViewById(R.id.listviewHinh);
        imgpath=new ArrayList<>();
        adapterImage=new AdapterImage(MainActivity.this,R.layout.item,imgpath);
        btnenter=findViewById(R.id.btnenter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }
}
