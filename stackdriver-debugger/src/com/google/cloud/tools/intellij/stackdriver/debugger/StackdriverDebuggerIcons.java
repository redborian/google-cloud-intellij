/*
 * Copyright 2018 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.tools.intellij.stackdriver.debugger;

import com.intellij.openapi.util.IconLoader;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/** Icons for the Stackdriver Debugger module. */
public class StackdriverDebuggerIcons {
  public static final Icon CLOUD_BREAKPOINT_FINAL = load("/icons/cloudsnapshotfinal.png");
  public static final Icon CLOUD_BREAKPOINT = load("/icons/cloudbreakpoint.png");
  public static final Icon CLOUD_BREAKPOINT_CHECKED = load("/icons/cloudbreakpointchecked.png");
  public static final Icon CLOUD_BREAKPOINT_ERROR = load("/icons/cloudbreakpointerror.png");
  public static final Icon CLOUD_BREAKPOINT_DISABLED = load("/icons/cloudbreakpointdisabled.png");
  public static final Icon CLOUD_DEBUG_SAVE_EXIT = load("/icons/debugsaveexit.png");
  public static final Icon CLOUD_DEBUG_REACTIVATE_BREAKPOINT =
      load("/icons/debugreactivatebreakpoint.png");
  public static final Icon CLOUD_DEBUG_DELETE_ALL_BREAKPOINTS = load("/icons/debugdeleteall.png");
  public static final Icon STACKDRIVER_DEBUGGER = load("/icons/stackdriverdebugger.png");

  private StackdriverDebuggerIcons() {
    // Not for instantiation.
  }

  private static Icon load(String path) {
    return IconLoader.getIcon(path, StackdriverDebuggerIcons.class);
  }

  private static Icon loadGif(String path) {
    return new ImageIcon(StackdriverDebuggerIcons.class.getResource(path));
  }
}
