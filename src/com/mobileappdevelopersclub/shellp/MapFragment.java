package com.mobileappdevelopersclub.shellp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class MapFragment extends Fragment {
	
	static String TAG = "MapFragment";
	int testInt;
	public static GoogleMap mMap;
	View view;
	
	public static MapFragment newInstance(int testInt) {
		MapFragment fragment = new MapFragment();
		fragment.testInt = testInt;
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		view = inflater.inflate(R.layout.map_fragment,  container, false);
		//((TextView)view.findViewById(R.id.textView1)).setText("Dylan is awesome, this is the new triv frag and it swipes really cool");
		setUpMapIfNeeded();
		return view;
	}
	
	
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
	}
	
	

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		 // Do Not Miss this
        try {
            Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));  
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.remove(fragment);
            ft.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	private void setUpMapIfNeeded() {
		// Do a null check to confirm that we have not already instantiated the map.

		Log.d(TAG, "Starting setUpMapIfNeeded");
		//Markers not implemented yet
//		if(markers == null) {
//			markers = new ArrayList<Marker>();
//		} else {
//			markers.clear();
//		}


		if (mMap == null) {
			FragmentManager ff = Globals.mgr;
			SupportMapFragment mf = ((SupportMapFragment) Globals.mgr.findFragmentById(R.id.map));
			mMap = ((SupportMapFragment) Globals.mgr.findFragmentById(R.id.map)).getMap();
			setUpMap();
		} else {
			mMap = ((SupportMapFragment) Globals.mgr.findFragmentById(R.id.map)).getMap();
			mMap.clear();
			setUpMap();
		}

	}
	
	private void setUpMap() {
		Log.d(TAG, "Setting up Map");
			//Code to set up a custom info window
//			Globals.mMap.setInfoWindowAdapter(new InfoWindowAdapter() {
//
//				// Use default InfoWindow frame
//				@Override
//				public View getInfoWindow(Marker arg0) {
//					return null;
//				}
//
//				// Defines the contents of the InfoWindow
//				@Override
//				public View getInfoContents(Marker arg0) {
//
//					// Getting view from the layout file info_window_layout
//					View v = currentInflater.inflate(R.layout.windowlayout, null);
//
//					// Getting reference to the TextView to set latitude
//					TextView title = (TextView) v.findViewById(R.id.title);
//
//					// Setting the latitude
//					title.setText(arg0.getTitle());
//
//					// Returning the view containing InfoWindow contents
//					return v;
//
//				}
//			});
//			}
//		}

		CameraUpdate center = null;
		center=
				CameraUpdateFactory.newLatLngBounds(new LatLngBounds( new LatLng(38.9806638 , -76.958377 ),
						new LatLng(38.998875, -76.933100)), 200 );

		
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(12);
		

		if (center != null) {
			mMap.moveCamera(center);
		}

		mMap.animateCamera(zoom);

	}

}
