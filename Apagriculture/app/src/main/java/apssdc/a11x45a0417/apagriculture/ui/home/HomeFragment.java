package apssdc.a11x45a0417.apagriculture.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import apssdc.a11x45a0417.apagriculture.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    ViewFlipper viewFlipper;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        int images[]={R.drawable.a1 ,R.drawable.a2,
                R.drawable.a3 ,R.drawable.avatar,

        };
        viewFlipper=root.findViewById( R.id.v_flipper );
        for (int image: images){
            flipperImages( image );
        }

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    private void flipperImages(int image)
    {

        ImageView imageView=new ImageView( getContext() );
        imageView.setBackgroundResource( image );
        viewFlipper.addView( imageView );
        viewFlipper.setFlipInterval( 2000 );
        viewFlipper.setAutoStart( true );

        viewFlipper.setInAnimation( getContext(),android.R.anim.slide_in_left );
        viewFlipper.setOutAnimation( getContext(),android.R.anim.slide_out_right );


    }
}