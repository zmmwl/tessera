package com.quorum.tessera.enclave;

import com.quorum.tessera.encryption.PublicKey;

/**
 * Encodes and decodes a {@link EncodedPayload} to and from its binary
 * representation
 */
public interface PayloadEncoder {

    /**
     * Encodes the payload to a byte array
     *
     * @param encodedPayloadWithRecipients the payload to encode
     * @return the byte array representing the encoded payload
     */
    byte[] encode(EncodedPayloadWithRecipients encodedPayloadWithRecipients);

    /**
     * Decodes a byte array back into an encrypted payload
     *
     * @param input The byte array to decode into an EncodedPayload
     * @return the decoded payload
     */
    EncodedPayloadWithRecipients decodePayloadWithRecipients(byte[] input);


    /**
     * Strips a payload of any data that isn't relevant to the given recipient
     * Used to format a payload before it is sent to the target node
     *
     * @param input the full payload from which data needs to be stripped
     * @param recipient the recipient to retain information about
     * @return a payload which contains a subset of data from the input, which is relevant to the recipient
     */
    EncodedPayloadWithRecipients forRecipient(EncodedPayloadWithRecipients input, PublicKey recipient);

    static PayloadEncoder create() {
        return new PayloadEncoderImpl();
    }
    
}