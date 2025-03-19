package edu.ucsc.cse118.assignment3;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import edu.ucsc.cse118.assignment3.databinding.FragmentChannelsBindingImpl;
import edu.ucsc.cse118.assignment3.databinding.FragmentCreateMessageBindingImpl;
import edu.ucsc.cse118.assignment3.databinding.FragmentDeleteMessageBindingImpl;
import edu.ucsc.cse118.assignment3.databinding.FragmentLoginBindingImpl;
import edu.ucsc.cse118.assignment3.databinding.FragmentMessageBindingImpl;
import edu.ucsc.cse118.assignment3.databinding.FragmentMessagesBindingImpl;
import edu.ucsc.cse118.assignment3.databinding.FragmentWorkspacesBindingImpl;
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
  private static final int LAYOUT_FRAGMENTCHANNELS = 1;

  private static final int LAYOUT_FRAGMENTCREATEMESSAGE = 2;

  private static final int LAYOUT_FRAGMENTDELETEMESSAGE = 3;

  private static final int LAYOUT_FRAGMENTLOGIN = 4;

  private static final int LAYOUT_FRAGMENTMESSAGE = 5;

  private static final int LAYOUT_FRAGMENTMESSAGES = 6;

  private static final int LAYOUT_FRAGMENTWORKSPACES = 7;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(7);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(edu.ucsc.cse118.assignment3.R.layout.fragment_channels, LAYOUT_FRAGMENTCHANNELS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(edu.ucsc.cse118.assignment3.R.layout.fragment_create_message, LAYOUT_FRAGMENTCREATEMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(edu.ucsc.cse118.assignment3.R.layout.fragment_delete_message, LAYOUT_FRAGMENTDELETEMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(edu.ucsc.cse118.assignment3.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(edu.ucsc.cse118.assignment3.R.layout.fragment_message, LAYOUT_FRAGMENTMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(edu.ucsc.cse118.assignment3.R.layout.fragment_messages, LAYOUT_FRAGMENTMESSAGES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(edu.ucsc.cse118.assignment3.R.layout.fragment_workspaces, LAYOUT_FRAGMENTWORKSPACES);
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
        case  LAYOUT_FRAGMENTCHANNELS: {
          if ("layout/fragment_channels_0".equals(tag)) {
            return new FragmentChannelsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_channels is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCREATEMESSAGE: {
          if ("layout/fragment_create_message_0".equals(tag)) {
            return new FragmentCreateMessageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_create_message is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTDELETEMESSAGE: {
          if ("layout/fragment_delete_message_0".equals(tag)) {
            return new FragmentDeleteMessageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_delete_message is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new FragmentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMESSAGE: {
          if ("layout/fragment_message_0".equals(tag)) {
            return new FragmentMessageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_message is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMESSAGES: {
          if ("layout/fragment_messages_0".equals(tag)) {
            return new FragmentMessagesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_messages is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWORKSPACES: {
          if ("layout/fragment_workspaces_0".equals(tag)) {
            return new FragmentWorkspacesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_workspaces is invalid. Received: " + tag);
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
    static final SparseArray<String> sKeys = new SparseArray<String>(8);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "channelsFragment");
      sKeys.put(2, "createMessageFragment");
      sKeys.put(3, "deleteMessageFragment");
      sKeys.put(4, "loginFragment");
      sKeys.put(5, "messageFragment");
      sKeys.put(6, "viewModel");
      sKeys.put(7, "workspacesFragment");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(7);

    static {
      sKeys.put("layout/fragment_channels_0", edu.ucsc.cse118.assignment3.R.layout.fragment_channels);
      sKeys.put("layout/fragment_create_message_0", edu.ucsc.cse118.assignment3.R.layout.fragment_create_message);
      sKeys.put("layout/fragment_delete_message_0", edu.ucsc.cse118.assignment3.R.layout.fragment_delete_message);
      sKeys.put("layout/fragment_login_0", edu.ucsc.cse118.assignment3.R.layout.fragment_login);
      sKeys.put("layout/fragment_message_0", edu.ucsc.cse118.assignment3.R.layout.fragment_message);
      sKeys.put("layout/fragment_messages_0", edu.ucsc.cse118.assignment3.R.layout.fragment_messages);
      sKeys.put("layout/fragment_workspaces_0", edu.ucsc.cse118.assignment3.R.layout.fragment_workspaces);
    }
  }
}
