/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.5
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.frostwire.jlibtorrent.swig;

public class upnp {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected upnp(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(upnp obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_upnp(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public int add_mapping(upnp.protocol_type p, int external_port, int local_port) {
    return libtorrent_jni.upnp_add_mapping(swigCPtr, this, p.swigValue(), external_port, local_port);
  }

  public void delete_mapping(int mapping_index) {
    libtorrent_jni.upnp_delete_mapping(swigCPtr, this, mapping_index);
  }

  public void discover_device() {
    libtorrent_jni.upnp_discover_device(swigCPtr, this);
  }

  public void close() {
    libtorrent_jni.upnp_close(swigCPtr, this);
  }

  public String router_model() {
    return libtorrent_jni.upnp_router_model(swigCPtr, this);
  }

  public boolean get_mapping(int mapping_index, int_vector res) {
    return libtorrent_jni.upnp_get_mapping(swigCPtr, this, mapping_index, int_vector.getCPtr(res), res);
  }

  public enum protocol_type {
    none(0),
    udp(1),
    tcp(2);

    public final int swigValue() {
      return swigValue;
    }

    public static protocol_type swigToEnum(int swigValue) {
      protocol_type[] swigValues = protocol_type.class.getEnumConstants();
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (protocol_type swigEnum : swigValues)
        if (swigEnum.swigValue == swigValue)
          return swigEnum;
      throw new IllegalArgumentException("No enum " + protocol_type.class + " with value " + swigValue);
    }

    @SuppressWarnings("unused")
    private protocol_type() {
      this.swigValue = SwigNext.next++;
    }

    @SuppressWarnings("unused")
    private protocol_type(int swigValue) {
      this.swigValue = swigValue;
      SwigNext.next = swigValue+1;
    }

    @SuppressWarnings("unused")
    private protocol_type(protocol_type swigEnum) {
      this.swigValue = swigEnum.swigValue;
      SwigNext.next = this.swigValue+1;
    }

    private final int swigValue;

    private static class SwigNext {
      private static int next = 0;
    }
  }

}
