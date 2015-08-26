package com.kafka;


import com.couchbase.client.core.message.dcp.MutationMessage;
import com.couchbase.client.deps.io.netty.util.CharsetUtil;
import com.couchbase.kafka.DCPEvent;
import com.couchbase.kafka.coder.AbstractEncoder;
import kafka.utils.VerifiableProperties;

public class SimpleEncoder extends AbstractEncoder {
    public SimpleEncoder(final VerifiableProperties properties) {
        super(properties);
    }

    @Override
    public byte[] toBytes(final DCPEvent dcpEvent) {
        MutationMessage message = (MutationMessage)dcpEvent.message();
        return message.content().toString(CharsetUtil.UTF_8).getBytes();
    }
}
