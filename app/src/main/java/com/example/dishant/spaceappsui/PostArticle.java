package com.example.dishant.spaceappsui;


import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostArticle extends Fragment {

    EditText title, content, tags;
    RecyclerView image_preview;
    LinearLayout linearLayout;
    Button submit;
    private static final int SELECT_PICTURE = 100;
    ArrayList<Uri> imgs;
    PreviewAdapter previewAdapter;

    public PostArticle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post_article, container, false);

        title = (EditText) view.findViewById(R.id.title);
        content = (EditText) view.findViewById(R.id.content);
        tags = (EditText) view.findViewById(R.id.tags);
        submit = (Button) view.findViewById(R.id.submit);
        linearLayout = (LinearLayout) view.findViewById(R.id.attach);
        image_preview = (RecyclerView) view.findViewById(R.id.image_preview);
        imgs = new ArrayList<>();


        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImageChooser();
            }
        });

        previewAdapter = new PreviewAdapter(getActivity(), imgs);
        image_preview.setAdapter(previewAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        image_preview.setLayoutManager(linearLayoutManager);

        return view;
    }

    void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // Get the path from the Uri
                    String path = getPathFromURI(selectedImageUri);
                    Log.i(TAG, "Image Path : " + path);
                    // Set the image in ImageView
                    if(imgs.size()<=10) {
                        imgs.add(selectedImageUri);
                        previewAdapter.notifyDataSetChanged();
                    }
                    else {
                        Toast.makeText(getActivity(), "Maximum 10 images", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }

    /* Get the real path from the URI */
    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getActivity().getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

}
