/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.nuage.javagiac.lib;

public class vectorg {
	private long swigCPtr;
	protected boolean swigCMemOwn;

	protected vectorg(long cPtr, boolean cMemoryOwn) {
		swigCMemOwn = cMemoryOwn;
		swigCPtr = cPtr;
	}

	protected static long getCPtr(vectorg obj) {
		return (obj == null) ? 0 : obj.swigCPtr;
	}

	@Override
	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (swigCPtr != 0 && swigCMemOwn) {
			swigCMemOwn = false;
			giacJNI.delete_vectorg(swigCPtr);
		}
		swigCPtr = 0;
	}

	public vectorg() {
		this(giacJNI.new_vectorg__SWIG_0(), true);
	}

	public vectorg(long n) {
		this(giacJNI.new_vectorg__SWIG_1(n), true);
	}

	public long size() {
		return giacJNI.vectorg_size(swigCPtr, this);
	}

	public long capacity() {
		return giacJNI.vectorg_capacity(swigCPtr, this);
	}

	public void reserve(long n) {
		giacJNI.vectorg_reserve(swigCPtr, this, n);
	}

	public boolean isEmpty() {
		return giacJNI.vectorg_isEmpty(swigCPtr, this);
	}

	public void clear() {
		giacJNI.vectorg_clear(swigCPtr, this);
	}

	public void add(gen x) {
		giacJNI.vectorg_add(swigCPtr, this, gen.getCPtr(x), x);
	}

	public gen get(int i) {
		return new gen(giacJNI.vectorg_get(swigCPtr, this, i), false);
	}

	public void set(int i, gen x) {
		giacJNI.vectorg_set(swigCPtr, this, i, gen.getCPtr(x), x);
	}

}
