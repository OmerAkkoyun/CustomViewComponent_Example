package com.example.customviewexample.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.example.customviewexample.R;
import com.example.customviewexample.databinding.ItemUserInfoBinding;

public class UserComponentView extends RelativeLayout {

    private TypedArray attributes;
    private ItemUserInfoBinding binding;


    public UserComponentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //inflate root view
        binding = ItemUserInfoBinding.inflate(LayoutInflater.from(context), this, true);
        attributes = context.obtainStyledAttributes(attrs, R.styleable.UserComponentView);
        initView();
    }

    private void initView() {
        // Username
        binding.tvUserName.setText(attributes.getString(R.styleable.UserComponentView_userName));
        binding.tvUserName.setTextSize(TypedValue.COMPLEX_UNIT_SP, (attributes.getInteger(R.styleable.UserComponentView_userNameSize, 14)));
        binding.tvUserName.setTextColor(attributes.getColor(R.styleable.UserComponentView_userNameColor, Color.BLACK));

        // Description
        binding.tvUserDescription.setText(attributes.getString(R.styleable.UserComponentView_description));
        binding.tvUserDescription.setTextSize(TypedValue.COMPLEX_UNIT_SP, (attributes.getInteger(R.styleable.UserComponentView_descriptionSize, 14)));
        binding.tvUserDescription.setTextColor(attributes.getColor(R.styleable.UserComponentView_descriptionColor, Color.BLACK));

        // User Photo
        String photo = attributes.getString(R.styleable.UserComponentView_userPhoto);
        if (photo != null && photo.length()>0){
            binding.imgUserPhoto.setImageDrawable(getContext().getDrawable(R.drawable.test));
        }else{
            binding.imgUserPhoto.setImageDrawable(getContext().getDrawable(R.drawable.help_icon));
        }


    }


    private float dpToPixel(float dpValue) {
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        float fpixels = metrics.density * dpValue;
        return (int) (fpixels + 0.5f);
    }

}
