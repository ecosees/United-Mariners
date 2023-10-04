package com.example.unitedmariners;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    ImageView profile_photo;
    ImageView user_name_edit;
    AlertDialog dialog;
    AlertDialog dialogPhoto;
    ImageView dialog_photo;


    TextView user_name, email, logOut, emailTxt, change_location, add_account;
    FirebaseAuth auth;
    FirebaseUser user;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        logOut = v.findViewById(R.id.logout);
        user_name = v.findViewById(R.id.user_name);
        emailTxt = v.findViewById(R.id.user_email);
        email = v.findViewById(R.id.email);
        user_name_edit = v.findViewById(R.id.user_name_edit);
        profile_photo = v.findViewById(R.id.profile_photo);
        change_location = v.findViewById(R.id.change_location);
        add_account = v.findViewById(R.id.add_account);


        /////////////////////////////////////////////////////////////////////////////

        user_name_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNameDialog();
                dialog.show();
                Log.d("suzan" , "set on click");
            }
        });


        profile_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPhotoDialog();
                dialogPhoto.show();


            }
        });


        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), login_screen.class);
                startActivity(intent);
                requireActivity().finish();

            }
        });


        change_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
                requireActivity().finish();

            }

        });

    add_account.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent intent = new Intent(getActivity(), sign_up_screen.class);
            startActivity(intent);
            requireActivity().finish();
          }
        });


        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if (user == null) {
            Intent intent = new Intent(getContext(), login_screen.class);
            startActivity(intent);
        } else {
            emailTxt.setText(user.getEmail());
        }
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getContext(), login_screen.class);
                startActivity(intent);
                requireActivity().finish();
            }
        });
        return v;
    }

    private void setPhotoDialog() {
        AlertDialog.Builder builder_photo = new AlertDialog.Builder(getActivity());

        View view_photo = getLayoutInflater().inflate(R.layout.profile_photo_layout, null);
        ImageButton im_back_photo;
        TextView tv_change, tv_delete;

        im_back_photo = view_photo.findViewById(R.id.im_back_photo);
        tv_change = view_photo.findViewById(R.id.tv_change);
        tv_delete = view_photo.findViewById(R.id.tv_delete);
        dialog_photo = view_photo.findViewById(R.id.dialog_photo);

        tv_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to open the file picker
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1234);


            }
        });


        tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_photo.setImageResource(R.drawable.default_photo);

            }
        });


        im_back_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogPhoto.dismiss();
            }
        });

        builder_photo.setView(view_photo);
        dialogPhoto = builder_photo.create();

    }

    private void setNameDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = getLayoutInflater().inflate(R.layout.name_dialog, null);
        ImageButton im_back;
        EditText et_name;
        Button btn_save_name;

        im_back = view.findViewById(R.id.im_back);
        et_name = view.findViewById(R.id.et_name);
        btn_save_name = view.findViewById(R.id.btn_save_name);

        btn_save_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_name.setText(user_name.getText().toString());
                dialog.dismiss();
            }
        });

        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        builder.setView(view);
        dialog = builder.create();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1234 && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            // Get the selected image URI
            Uri selectedImageUri = data.getData();
            dialog_photo.setImageURI(selectedImageUri);


        }
    }

}