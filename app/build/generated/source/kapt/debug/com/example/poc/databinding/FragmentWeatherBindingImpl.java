package com.example.poc.databinding;
import com.example.poc.R;
import com.example.poc.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentWeatherBindingImpl extends FragmentWeatherBinding implements com.example.poc.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.weather_condition_image, 4);
        sViewsWithIds.put(R.id.tv_weather_condition, 5);
        sViewsWithIds.put(R.id.tv_weather_description, 6);
        sViewsWithIds.put(R.id.card_weather, 7);
        sViewsWithIds.put(R.id.temperature_img, 8);
        sViewsWithIds.put(R.id.tv_temp, 9);
        sViewsWithIds.put(R.id.tv_feels_like, 10);
        sViewsWithIds.put(R.id.imageView2, 11);
        sViewsWithIds.put(R.id.tv_wind_speed, 12);
        sViewsWithIds.put(R.id.tv_max_temp, 13);
        sViewsWithIds.put(R.id.tv_min_temp, 14);
        sViewsWithIds.put(R.id.textView6, 15);
        sViewsWithIds.put(R.id.imageView3, 16);
        sViewsWithIds.put(R.id.tv_humidity, 17);
        sViewsWithIds.put(R.id.forecast_recycler_view, 18);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener searchViewandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.cityName
            //         is viewModel.setCityName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(searchView);
            // localize variables for thread safety
            // viewModel
            weather.WeatherViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.cityName
            java.lang.String viewModelCityName = null;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setCityName(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentWeatherBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private FragmentWeatherBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[2]
            , (androidx.cardview.widget.CardView) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[18]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ProgressBar) bindings[3]
            , (android.widget.AutoCompleteTextView) bindings[1]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[12]
            , (android.widget.ImageView) bindings[4]
            );
        this.btnWeatherGo.setTag(null);
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.progressBarWeather.setTag(null);
        this.searchView.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.poc.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((weather.WeatherViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable weather.WeatherViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelPBarVisibility((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelPBarVisibility(androidx.lifecycle.MutableLiveData<java.lang.Boolean> ViewModelPBarVisibility, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.Boolean viewModelPBarVisibilityGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelPBarVisibility = null;
        int viewModelPBarVisibilityViewVISIBLEViewINVISIBLE = 0;
        java.lang.String viewModelCityName = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelPBarVisibilityGetValue = false;
        weather.WeatherViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.pBarVisibility
                    viewModelPBarVisibility = viewModel.getPBarVisibility();
                }
                updateLiveDataRegistration(0, viewModelPBarVisibility);


                if (viewModelPBarVisibility != null) {
                    // read viewModel.pBarVisibility.getValue()
                    viewModelPBarVisibilityGetValue = viewModelPBarVisibility.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.pBarVisibility.getValue())
                androidxDatabindingViewDataBindingSafeUnboxViewModelPBarVisibilityGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelPBarVisibilityGetValue);
            if((dirtyFlags & 0x7L) != 0) {
                if(androidxDatabindingViewDataBindingSafeUnboxViewModelPBarVisibilityGetValue) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.pBarVisibility.getValue()) ? View.VISIBLE : View.INVISIBLE
                viewModelPBarVisibilityViewVISIBLEViewINVISIBLE = ((androidxDatabindingViewDataBindingSafeUnboxViewModelPBarVisibilityGetValue) ? (android.view.View.VISIBLE) : (android.view.View.INVISIBLE));
            if ((dirtyFlags & 0x6L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.cityName
                        viewModelCityName = viewModel.getCityName();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.btnWeatherGo.setOnClickListener(mCallback1);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.searchView, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, searchViewandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            this.progressBarWeather.setVisibility(viewModelPBarVisibilityViewVISIBLEViewINVISIBLE);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.searchView, viewModelCityName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        weather.WeatherViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.fetchWeatherData();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.pBarVisibility
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
        flag 3 (0x4L): androidx.databinding.ViewDataBinding.safeUnbox(viewModel.pBarVisibility.getValue()) ? View.VISIBLE : View.INVISIBLE
        flag 4 (0x5L): androidx.databinding.ViewDataBinding.safeUnbox(viewModel.pBarVisibility.getValue()) ? View.VISIBLE : View.INVISIBLE
    flag mapping end*/
    //end
}