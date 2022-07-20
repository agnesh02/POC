package com.example.poc.databinding;
import com.example.poc.R;
import com.example.poc.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentLoginBindingImpl extends FragmentLoginBinding implements com.example.poc.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textInputLayout7, 6);
        sViewsWithIds.put(R.id.textInputLayout5, 7);
        sViewsWithIds.put(R.id.tv_login_go_to_register, 8);
        sViewsWithIds.put(R.id.tv_login_reset_password, 9);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener checkBoxandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.checkBoxStatus
            //         is viewModel.setCheckBoxStatus((boolean) callbackArg_0)
            boolean callbackArg_0 = checkBox.isChecked();
            // localize variables for thread safety
            // viewModel.checkBoxStatus
            boolean viewModelCheckBoxStatus = false;
            // viewModel
            authentication.AuthenticationViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setCheckBoxStatus(((boolean) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener etLoginEmailIdandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.etEmail
            //         is viewModel.setEtEmail((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etLoginEmailId);
            // localize variables for thread safety
            // viewModel.etEmail
            java.lang.String viewModelEtEmail = null;
            // viewModel
            authentication.AuthenticationViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setEtEmail(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener etLoginPasswordandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.etPass
            //         is viewModel.setEtPass((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etLoginPassword);
            // localize variables for thread safety
            // viewModel.etPass
            java.lang.String viewModelEtPass = null;
            // viewModel
            authentication.AuthenticationViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setEtPass(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private FragmentLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[3]
            , (android.widget.CheckBox) bindings[4]
            , (com.google.android.material.textfield.TextInputEditText) bindings[1]
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (android.widget.ProgressBar) bindings[5]
            , (com.google.android.material.textfield.TextInputLayout) bindings[7]
            , (com.google.android.material.textfield.TextInputLayout) bindings[6]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            );
        this.btnLoginLogin.setTag(null);
        this.checkBox.setTag(null);
        this.etLoginEmailId.setTag(null);
        this.etLoginPassword.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.progressBarLogin.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.example.poc.generated.callback.OnClickListener(this, 1);
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
            setViewModel((authentication.AuthenticationViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable authentication.AuthenticationViewModel ViewModel) {
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
        boolean viewModelCheckBoxStatus = false;
        int viewModelPBarVisibilityViewVISIBLEViewINVISIBLE = 0;
        java.lang.String viewModelEtEmail = null;
        java.lang.String viewModelEtPass = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelPBarVisibilityGetValue = false;
        authentication.AuthenticationViewModel viewModel = mViewModel;

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
                        // read viewModel.checkBoxStatus
                        viewModelCheckBoxStatus = viewModel.getCheckBoxStatus();
                        // read viewModel.etEmail
                        viewModelEtEmail = viewModel.getEtEmail();
                        // read viewModel.etPass
                        viewModelEtPass = viewModel.getEtPass();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.btnLoginLogin.setOnClickListener(mCallback2);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.checkBox, (android.widget.CompoundButton.OnCheckedChangeListener)null, checkBoxandroidCheckedAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etLoginEmailId, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etLoginEmailIdandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etLoginPassword, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etLoginPasswordandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.checkBox, viewModelCheckBoxStatus);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etLoginEmailId, viewModelEtEmail);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etLoginPassword, viewModelEtPass);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            this.progressBarLogin.setVisibility(viewModelPBarVisibilityViewVISIBLEViewINVISIBLE);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        authentication.AuthenticationViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.onLogin();
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