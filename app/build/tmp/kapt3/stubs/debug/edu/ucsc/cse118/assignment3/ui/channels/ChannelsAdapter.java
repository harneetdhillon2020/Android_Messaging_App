package edu.ucsc.cse118.assignment3.ui.channels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Ledu/ucsc/cse118/assignment3/ui/channels/ChannelsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ledu/ucsc/cse118/assignment3/ui/channels/ChannelsAdapter$ChannelViewHolder;", "channels", "Ljava/util/ArrayList;", "Ledu/ucsc/cse118/assignment3/data/Channel;", "Lkotlin/collections/ArrayList;", "listener", "Ledu/ucsc/cse118/assignment3/ui/channels/ChannelsListener;", "(Ljava/util/ArrayList;Ledu/ucsc/cse118/assignment3/ui/channels/ChannelsListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ChannelViewHolder", "app_debug"})
public final class ChannelsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<edu.ucsc.cse118.assignment3.ui.channels.ChannelsAdapter.ChannelViewHolder> {
    private final java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Channel> channels = null;
    private final edu.ucsc.cse118.assignment3.ui.channels.ChannelsListener listener = null;
    
    public ChannelsAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Channel> channels, @org.jetbrains.annotations.NotNull
    edu.ucsc.cse118.assignment3.ui.channels.ChannelsListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public edu.ucsc.cse118.assignment3.ui.channels.ChannelsAdapter.ChannelViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    edu.ucsc.cse118.assignment3.ui.channels.ChannelsAdapter.ChannelViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Ledu/ucsc/cse118/assignment3/ui/channels/ChannelsAdapter$ChannelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ItemView", "Landroid/view/View;", "(Landroid/view/View;)V", "messages", "Landroid/widget/TextView;", "name", "bind", "", "channel", "Ledu/ucsc/cse118/assignment3/data/Channel;", "app_debug"})
    public static final class ChannelViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView name = null;
        private final android.widget.TextView messages = null;
        
        public ChannelViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View ItemView) {
            super(null);
        }
        
        @android.annotation.SuppressLint(value = {"SetTextI18n"})
        public final void bind(@org.jetbrains.annotations.NotNull
        edu.ucsc.cse118.assignment3.data.Channel channel) {
        }
    }
}