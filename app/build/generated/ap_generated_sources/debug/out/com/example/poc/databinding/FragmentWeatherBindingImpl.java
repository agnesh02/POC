package com.example.poc.databinding;
import com.example.poc.R;
import com.example.poc.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentWeatherBindingImpl extends FragmentWeatherBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.searchView, 1);
        sViewsWithIds.put(R.id.btn_weather_go, 2);
        sViewsWithIds.put(R.id.weather_condition_image, 3);
        sViewsWithIds.put(R.id.tv_weather_condition, 4);
        sViewsWithIds.put(R.id.tv_weather_description, 5);
        sViewsWithIds.put(R.id.card_weather, 6);
        sViewsWithIds.put(R.id.temperature_img, 7);
        sViewsWithIds.put(R.id.tv_temp, 8);
        sViewsWithIds.put(R.id.tv_feels_like, 9);
        sViewsWithIds.put(R.id.imageView2, 10);
        sViewsWithIds.put(R.id.tv_wind_speed, 11);
        sViewsWithIds.put(R.id.tv_max_temp, 12);
        sViewsWithIds.put(R.id.tv_min_temp, 13);
        sViewsWithIds.put(R.id.textView6, 14);
        sViewsWithIds.put(R.id.imageView3, 15);
        sViewsWithIds.put(R.id.tv_humidity, 16);
        sViewsWithIds.put(R.id.forecast_recycler_view, 17);
        sViewsWithIds.put(R.id.progressBar_weather, 18);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentWeatherBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private FragmentWeatherBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[2]
            , (androidx.cardview.widget.CardView) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[17]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ProgressBar) bindings[18]
            , (android.widget.AutoCompleteTextView) bindings[1]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[11]
            , (android.widget.ImageView) bindings[3]
            );
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}