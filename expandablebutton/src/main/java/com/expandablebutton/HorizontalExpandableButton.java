package com.expandablebutton;

/*
 *
 * This file 'HorizontalExpandableButton.java' is part of Expandable Button :
 *
 * Copyright (c) 2016 Stanly Moses.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * OR <http://www.gnu.org/licenses/gpl-3.0.txt>
 *
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.expandablebutton.factory.ExpandableFactory;

public class HorizontalExpandableButton extends FrameLayout {


    private TextView     expansionText;
    private LinearLayout button;
    private LinearLayout buttonIcon;
    private ImageView    icon;
    private Drawable     drawable;
    private TypedArray   typedArray;

    private String          buttonText;
    private int             expandableButtonColor;
    private int             iconButtonColor;
    private int             textColor;
    private OnClickListener onClickListener;

    public HorizontalExpandableButton(Context context) {
        super(context);
        initView(context);
    }

    public HorizontalExpandableButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExpandableButton);
        if (typedArray != null) {
            buttonText = typedArray.getString(R.styleable.ExpandableButton_hide_text);
            expandableButtonColor = typedArray.getColor(R.styleable.ExpandableButton_expandable_area_color, Color.parseColor("#FFE6E4E4"));
            iconButtonColor = typedArray.getColor(R.styleable.ExpandableButton_icon_button_color, Color.parseColor("#FFE6E4E4"));
            textColor = typedArray.getColor(R.styleable.ExpandableButton_hide_text_color, Color.parseColor("#FFE6E4E4"));
            drawable = typedArray.getDrawable(R.styleable.ExpandableButton_button_icon);
        }
        initView(context);
    }

    public void setExpansionListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.horizontal_expandable_btn, this, true);
        button = (LinearLayout) findViewById(R.id.expandable_button);
        buttonIcon = (LinearLayout) findViewById(R.id.icon_button);
        expansionText = (TextView) findViewById(R.id.btn_text);
        expansionText.setSelected(true);
        icon = (ImageView) findViewById(R.id.btn_icon);
        initButton();
        attachButtonListener();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void initButton() {
        if (drawable != null) {
            icon.setBackground(drawable);
        }
        ((GradientDrawable) button.getBackground()).setColor(expandableButtonColor);
        ((GradientDrawable) buttonIcon.getBackground()).setColor(iconButtonColor);
        expansionText.setText(buttonText);
        expansionText.setTextColor(textColor);
        expansionText.setGravity(Gravity.CENTER);
        initSize();
    }

    private void initSize() {
        button.getLayoutParams().width = (int) typedArray.getDimension(R.styleable.ExpandableButton_expandable_button_size, 50);
        button.getLayoutParams().height = (int) typedArray.getDimension(R.styleable.ExpandableButton_expandable_button_size, 50);
        buttonIcon.getLayoutParams().width = (int) typedArray.getDimension(R.styleable.ExpandableButton_expandable_button_size, 50);
        buttonIcon.getLayoutParams().height = (int) typedArray.getDimension(R.styleable.ExpandableButton_expandable_button_size, 50);
        icon.getLayoutParams().width = (int) typedArray.getDimension(R.styleable.ExpandableButton_button_icon_width, 25);
        icon.getLayoutParams().height = (int) typedArray.getDimension(R.styleable.ExpandableButton_button_icon_height, 25);
        expansionText.setTextSize(typedArray.getDimension(R.styleable.ExpandableButton_hide_text_size, 15));
    }

    private void attachButtonListener() {
        this.button.setOnClickListener(v -> {
            if (v.getWidth() == v.getHeight()) {
                expansionText.setVisibility(VISIBLE);
                button.setVisibility(VISIBLE);
            } else {
                expansionText.setVisibility(GONE);
                button.setVisibility(INVISIBLE);
                if (onClickListener != null) onClickListener.onClick(button);
            }
            ExpandableFactory.getDilatableView("Horizontal").dilateWith(v);
        });
    }
}