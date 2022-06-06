package com.draw.master.tool.ext

import android.content.Context
import com.draw.master.tool.h.Config

val Context.config: Config get() = Config.newInstance(applicationContext)
