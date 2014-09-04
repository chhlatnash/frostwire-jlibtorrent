/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.frostwire.libtorrent.swig;

public class feed_settings {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected feed_settings(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(feed_settings obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_feed_settings(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public feed_settings() {
    this(libtorrent_jni.new_feed_settings(), true);
  }

  public void setUrl(String value) {
    libtorrent_jni.feed_settings_url_set(swigCPtr, this, value);
  }

  public String getUrl() {
    return libtorrent_jni.feed_settings_url_get(swigCPtr, this);
  }

  public void setAuto_download(boolean value) {
    libtorrent_jni.feed_settings_auto_download_set(swigCPtr, this, value);
  }

  public boolean getAuto_download() {
    return libtorrent_jni.feed_settings_auto_download_get(swigCPtr, this);
  }

  public void setAuto_map_handles(boolean value) {
    libtorrent_jni.feed_settings_auto_map_handles_set(swigCPtr, this, value);
  }

  public boolean getAuto_map_handles() {
    return libtorrent_jni.feed_settings_auto_map_handles_get(swigCPtr, this);
  }

  public void setDefault_ttl(int value) {
    libtorrent_jni.feed_settings_default_ttl_set(swigCPtr, this, value);
  }

  public int getDefault_ttl() {
    return libtorrent_jni.feed_settings_default_ttl_get(swigCPtr, this);
  }

  public void setAdd_args(add_torrent_params value) {
    libtorrent_jni.feed_settings_add_args_set(swigCPtr, this, add_torrent_params.getCPtr(value), value);
  }

  public add_torrent_params getAdd_args() {
    long cPtr = libtorrent_jni.feed_settings_add_args_get(swigCPtr, this);
    return (cPtr == 0) ? null : new add_torrent_params(cPtr, false);
  }

}