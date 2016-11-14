package com.expandablebutton.animation;

/*
 *
 * This file 'HorizontalAnimation.java' is part of Expandable Button :
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

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class HorizontalAnimation extends Animation {
    private int  toHeight;
    private int  startHeight;
    private View view;

    public HorizontalAnimation(View view) {
        this.view = view;
        this.startHeight = this.view.getHeight();
        if (startHeight == view.getHeight()) {
            this.toHeight = this.startHeight * 4;
        } else {
            this.toHeight = view.getHeight();
        }
    }

    protected void applyTransformation(float interpolatedTime, Transformation t) {
        this.view.getLayoutParams().height = this.startHeight + (int) ((this.toHeight - this.startHeight) * interpolatedTime);
        this.view.requestLayout();
    }
}
