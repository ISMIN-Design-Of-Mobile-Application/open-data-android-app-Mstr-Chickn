package com.ismin.opendataapp

import android.media.Image
import java.io.Serializable
data class Element(val name: String, val biographic_data: String, val photo: Image?): Serializable