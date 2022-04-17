package com.example.hslb;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class OrderPlaced extends Fragment {
    String m_Text = "";
    //TextView mEditText;
    LinearLayout mLayout;

    public OrderPlaced() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_order_placed, container, false);
        TextView mEditText = new TextView(getContext());
        mLayout = (LinearLayout) rootView.findViewById(R.id.linearlayout);
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.floating_action_button);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        final EditText input = new EditText(getContext());
        builder.setTitle("ADD ORDER");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LinearLayout ll = new LinearLayout(getContext());
                        ll.setOrientation(LinearLayout.HORIZONTAL);
                        m_Text = input.getText().toString();
                        System.out.println(m_Text);
                        mEditText.setText(m_Text);
                        mEditText.setWidth(100);

                        mEditText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT));
                        ll.addView(mEditText);

                        mLayout.addView(ll);
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
        return rootView;
    }
}