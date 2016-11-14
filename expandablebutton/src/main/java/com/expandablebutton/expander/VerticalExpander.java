package com.expandablebutton.expander;

/*
 *
 * This file 'VerticalExpander.java' is part of Expandable Button :
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

import com.expandablebutton.animation.VerticalAnimation;
import com.expandablebutton.interfaces.Dilate;

public class VerticalExpander implements Dilate {
    @Override
    public void dilateWith(View button) {
        VerticalAnimation animator = new VerticalAnimation(button);
        animator.setDuration(200L);
        button.startAnimation(animator);
    }
}
