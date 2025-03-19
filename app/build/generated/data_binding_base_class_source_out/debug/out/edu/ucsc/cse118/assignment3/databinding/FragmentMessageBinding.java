// Generated by data binding compiler. Do not edit!
package edu.ucsc.cse118.assignment3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import edu.ucsc.cse118.assignment3.R;
import edu.ucsc.cse118.assignment3.model.SharedViewModel;
import edu.ucsc.cse118.assignment3.ui.message.MessageFragment;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentMessageBinding extends ViewDataBinding {
  @NonNull
  public final TextView content;

  @NonNull
  public final TextView date;

  @Bindable
  protected SharedViewModel mViewModel;

  @Bindable
  protected MessageFragment mMessageFragment;

  protected FragmentMessageBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView content, TextView date) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    this.date = date;
  }

  public abstract void setViewModel(@Nullable SharedViewModel viewModel);

  @Nullable
  public SharedViewModel getViewModel() {
    return mViewModel;
  }

  public abstract void setMessageFragment(@Nullable MessageFragment messageFragment);

  @Nullable
  public MessageFragment getMessageFragment() {
    return mMessageFragment;
  }

  @NonNull
  public static FragmentMessageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_message, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMessageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentMessageBinding>inflateInternal(inflater, R.layout.fragment_message, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMessageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_message, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMessageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentMessageBinding>inflateInternal(inflater, R.layout.fragment_message, null, false, component);
  }

  public static FragmentMessageBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentMessageBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentMessageBinding)bind(component, view, R.layout.fragment_message);
  }
}
