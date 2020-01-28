package com.danielngandu.nearbychurhces.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.danielngandu.nearbychurhces.R;
import com.danielngandu.nearbychurhces.adapter.PlaceUserRatingAdapter;
import com.danielngandu.nearbychurhces.model.PlaceUserRating;
import com.danielngandu.nearbychurhces.utils.GoogleApiUrl;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceReviewDetail extends Fragment {

    /**
     * all references
     */
    private ArrayList<PlaceUserRating> mPlaceUserRatingArrayList = new ArrayList<>();
    private PlaceUserRatingAdapter mPlaceUserRatingAdapter;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_place_review_detail, container, false);
        mPlaceUserRatingArrayList = getArguments()
                .getParcelableArrayList(GoogleApiUrl.CURRENT_LOCATION_USER_RATING_KEY);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        if (mPlaceUserRatingArrayList.size() == 0) {
            rootView.findViewById(R.id.empty_view).setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        } else {
            rootView.findViewById(R.id.empty_view).setVisibility(View.GONE);
            mPlaceUserRatingAdapter = new PlaceUserRatingAdapter(getActivity(), mPlaceUserRatingArrayList);
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
            mRecyclerView.setAdapter(mPlaceUserRatingAdapter);
        }
        return rootView;
    }
}
