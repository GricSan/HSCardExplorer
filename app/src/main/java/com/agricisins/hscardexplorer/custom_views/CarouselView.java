package com.agricisins.hscardexplorer.custom_views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.agricisins.hscardexplorer.R;

import java.util.ArrayList;

public class CarouselView extends LinearLayout implements View.OnClickListener {

    private static final String TAG = "GricSan_Log";

    private boolean isAnimated = false;

    private ArrayList<Integer> mData;
    private int mLeftPositionCounter = 0;
    private int mCentralPositionCounter = 1;
    private int mRightPositionCounter = 2;


    private ImageView mLeftReserveImage;
    private ImageView mLeftImage;
    private ImageView mCenterImage;
    private ImageView mRightImage;
    private ImageView mRightReserveImage;

    private FrameLayout mLeftImageContainer;
    private FrameLayout mCenterImageContainer;
    private FrameLayout mRightImageContainer;


    public CarouselView(Context context) {
        super(context);
        initViews(context);
    }

    public CarouselView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    public CarouselView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context);
    }

    private void initViews(Context context) {
        LayoutInflater.from(context).inflate(R.layout.carousel_view, this);
        mData = new ArrayList<>();
        mData.add(R.drawable.dru_shit);
        mData.add(R.drawable.mind_control);
        mData.add(R.drawable.op_shit);
        mData.add(R.drawable.pyroblast);
        mData.add(R.drawable.warlock_op_op);

        mLeftReserveImage = (ImageView) findViewById(R.id.carousel_left_reserve_image);
        mLeftImage = (ImageView) findViewById(R.id.carousel_left_image);
        mCenterImage = (ImageView) findViewById(R.id.carousel_center_image);
        mRightImage = (ImageView) findViewById(R.id.carousel_right_image);
        mRightReserveImage = (ImageView) findViewById(R.id.carousel_right_reserve_image);

        redrawImages();

        mLeftImageContainer = (FrameLayout) findViewById(R.id.carousel_left_container);
        mCenterImageContainer = (FrameLayout) findViewById(R.id.carousel_center_container);
        mRightImageContainer = (FrameLayout) findViewById(R.id.carousel_right_container);

        mLeftImageContainer.setOnClickListener(this);
        mCenterImageContainer.setOnClickListener(this);
        mRightImageContainer.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.carousel_left_container: {
                scrollRight();
                break;
            }

            case R.id.carousel_center_container: {
                enlargeView();
                break;
            }

            case R.id.carousel_right_container: {
                scrollLeft();
                break;
            }

            default: {
                break;
            }
        }

    }


    private void enlargeView() {

    }

    private void scrollLeft() {
        mLeftPositionCounter = mCentralPositionCounter;
        mCentralPositionCounter = mRightPositionCounter;
        mRightPositionCounter++;

        if (mRightPositionCounter == mData.size()) {
            mRightPositionCounter = 0;
        }

        redrawImages();
    }

    private void scrollRight() {
        mRightPositionCounter = mCentralPositionCounter;
        mCentralPositionCounter = mLeftPositionCounter;
        mLeftPositionCounter--;

        if (mLeftPositionCounter < 0) {
            mLeftPositionCounter = mData.size() - 1;
        }

        redrawImages();
    }

    private void redrawImages() {
        mLeftImage.setImageResource(mData.get(mLeftPositionCounter));
        mCenterImage.setImageResource(mData.get(mCentralPositionCounter));
        mRightImage.setImageResource(mData.get(mRightPositionCounter));
    }

    /**
     * @param data to be displayed in Carousel
     */
    public void setData(ArrayList<Integer> data) {
        mData = data;
    }

    /**
     * @return the number of items in Carousel
     */
    public int getDataSize() {
        return mData.size();
    }

    /**
     * @return "true" if transition between items is animated
     */
    public boolean isAnimated() {
        return isAnimated;
    }

    /**
     * @param isAnimated indicates whether transition between items should be animated
     */
    public void setAnimated(boolean isAnimated) {
        this.isAnimated = isAnimated;
    }
}
