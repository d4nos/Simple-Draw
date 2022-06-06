package com.draw.master.tool.extensions

import android.content.Context
import com.draw.master.tool.helpers.Config

val Context.config: Config get() = Config.newInstance(applicationContext)
