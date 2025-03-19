// Generated by data binding compiler. Do not edit!
package edu.ucsc.cse118.assignment3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.ucsc.cse118.assignment3.R;
import edu.ucsc.cse118.assignment3.model.SharedViewModel;
import edu.ucsc.cse118.assignment3.ui.messages.MessagesFragment;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentMessagesBinding extends ViewDataBinding {
  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final RecyclerView recyclerview;

  @Bindable
  protected SharedViewModel mViewModel;

  @Bindable
  protected MessagesFragment mChannelsFragment;

  protected FragmentMessagesBinding(Object _bindingComponent, View _root, int _localFieldCount,
      FloatingActionButton fab, RecyclerView recyclerview) {
    super(_bindingComponent, _root, _localFieldCount);
    this.fab = fab;
    this.recyclerview = recyclerview;
  }

  public abstract void setViewModel(@Nullable SharedViewModel viewModel);

  @Nullable
  public SharedViewModel getViewModel() {
    return mViewModel;
  }

  public abstract void setChannelsFragment(@Nullable MessagesFragment channelsFragment);

  @Nullable
  public MessagesFragment getChannelsFragment() {
    return mChannelsFragment;
  }

  @NonNull
  public static FragmentMessagesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_messages, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMessagesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentMessagesBinding>inflateInternal(inflater, R.layout.fragment_messages, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMessagesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_messages, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMessagesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentMessagesBinding>inflateInternal(inflater, R.layout.fragment_messages, null, false, component);
  }

  public static FragmentMessagesBinding bind(@NonNull View view) {
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
  public static FragmentMessagesBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentMessagesBinding)bind(component, view, R.layout.fragment_messages);
  }
}
