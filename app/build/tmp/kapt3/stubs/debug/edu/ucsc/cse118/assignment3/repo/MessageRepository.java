package edu.ucsc.cse118.assignment3.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004J*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ0\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000e2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000eH\u0002\u00a8\u0006\u0011"}, d2 = {"Ledu/ucsc/cse118/assignment3/repo/MessageRepository;", "", "()V", "createOne", "Ledu/ucsc/cse118/assignment3/data/Message;", "member", "Ledu/ucsc/cse118/assignment3/data/Member;", "channel", "Ledu/ucsc/cse118/assignment3/data/Channel;", "message", "deleteOne", "", "getAllMessages", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sortMessagesByDateDescending", "messages", "app_debug"})
public final class MessageRepository {
    
    public MessageRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Message> getAllMessages(@org.jetbrains.annotations.Nullable
    edu.ucsc.cse118.assignment3.data.Member member, @org.jetbrains.annotations.Nullable
    edu.ucsc.cse118.assignment3.data.Channel channel) {
        return null;
    }
    
    private final java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Message> sortMessagesByDateDescending(java.util.ArrayList<edu.ucsc.cse118.assignment3.data.Message> messages) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final edu.ucsc.cse118.assignment3.data.Message createOne(@org.jetbrains.annotations.Nullable
    edu.ucsc.cse118.assignment3.data.Member member, @org.jetbrains.annotations.Nullable
    edu.ucsc.cse118.assignment3.data.Channel channel, @org.jetbrains.annotations.Nullable
    edu.ucsc.cse118.assignment3.data.Message message) {
        return null;
    }
    
    public final void deleteOne(@org.jetbrains.annotations.Nullable
    edu.ucsc.cse118.assignment3.data.Member member, @org.jetbrains.annotations.Nullable
    edu.ucsc.cse118.assignment3.data.Message message) {
    }
}