package com.example.poc;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.poc.databinding.FragmentDashboardBindingImpl;
import com.example.poc.databinding.FragmentEditProfileBindingImpl;
import com.example.poc.databinding.FragmentLoginBindingImpl;
import com.example.poc.databinding.FragmentProfileBindingImpl;
import com.example.poc.databinding.FragmentProfilePictureBindingImpl;
import com.example.poc.databinding.FragmentRegistrationBindingImpl;
import com.example.poc.databinding.FragmentResetPasswordBindingImpl;
import com.example.poc.databinding.FragmentWeatherBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTDASHBOARD = 1;

  private static final int LAYOUT_FRAGMENTEDITPROFILE = 2;

  private static final int LAYOUT_FRAGMENTLOGIN = 3;

  private static final int LAYOUT_FRAGMENTPROFILE = 4;

  private static final int LAYOUT_FRAGMENTPROFILEPICTURE = 5;

  private static final int LAYOUT_FRAGMENTREGISTRATION = 6;

  private static final int LAYOUT_FRAGMENTRESETPASSWORD = 7;

  private static final int LAYOUT_FRAGMENTWEATHER = 8;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(8);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.poc.R.layout.fragment_dashboard, LAYOUT_FRAGMENTDASHBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.poc.R.layout.fragment_edit_profile, LAYOUT_FRAGMENTEDITPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.poc.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.poc.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.poc.R.layout.fragment_profile_picture, LAYOUT_FRAGMENTPROFILEPICTURE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.poc.R.layout.fragment_registration, LAYOUT_FRAGMENTREGISTRATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.poc.R.layout.fragment_reset_password, LAYOUT_FRAGMENTRESETPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.poc.R.layout.fragment_weather, LAYOUT_FRAGMENTWEATHER);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTDASHBOARD: {
          if ("layout/fragment_dashboard_0".equals(tag)) {
            return new FragmentDashboardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_dashboard is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTEDITPROFILE: {
          if ("layout/fragment_edit_profile_0".equals(tag)) {
            return new FragmentEditProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_edit_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new FragmentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPROFILE: {
          if ("layout/fragment_profile_0".equals(tag)) {
            return new FragmentProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPROFILEPICTURE: {
          if ("layout/fragment_profile_picture_0".equals(tag)) {
            return new FragmentProfilePictureBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_profile_picture is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREGISTRATION: {
          if ("layout/fragment_registration_0".equals(tag)) {
            return new FragmentRegistrationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_registration is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTRESETPASSWORD: {
          if ("layout/fragment_reset_password_0".equals(tag)) {
            return new FragmentResetPasswordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_reset_password is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWEATHER: {
          if ("layout/fragment_weather_0".equals(tag)) {
            return new FragmentWeatherBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_weather is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(8);

    static {
      sKeys.put("layout/fragment_dashboard_0", com.example.poc.R.layout.fragment_dashboard);
      sKeys.put("layout/fragment_edit_profile_0", com.example.poc.R.layout.fragment_edit_profile);
      sKeys.put("layout/fragment_login_0", com.example.poc.R.layout.fragment_login);
      sKeys.put("layout/fragment_profile_0", com.example.poc.R.layout.fragment_profile);
      sKeys.put("layout/fragment_profile_picture_0", com.example.poc.R.layout.fragment_profile_picture);
      sKeys.put("layout/fragment_registration_0", com.example.poc.R.layout.fragment_registration);
      sKeys.put("layout/fragment_reset_password_0", com.example.poc.R.layout.fragment_reset_password);
      sKeys.put("layout/fragment_weather_0", com.example.poc.R.layout.fragment_weather);
    }
  }
}
