/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.tools.intellij.gcs;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.tools.intellij.testing.CloudToolsRule;
import com.google.cloud.tools.intellij.testing.TestFixture;
import com.intellij.testFramework.fixtures.IdeaProjectTestFixture;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/** Tests for {@link GcsBucketPanel}. */
public class GcsBucketPanelTest {
  @Rule public final CloudToolsRule cloudToolsRule = new CloudToolsRule(this);
  @TestFixture private IdeaProjectTestFixture testFixture;

  private GcsBucketPanel bucketPanel;

  @Before
  public void setUp() {
    bucketPanel = new GcsBucketPanel(testFixture.getProject());
  }

  @Test
  public void testPanelInitializationState() {
    assertTrue(bucketPanel.getComponent().isVisible());
    assertTrue(bucketPanel.getNotificationPanel().isVisible());
    assertFalse(bucketPanel.getBucketListPanel().isVisible());

    assertThat(bucketPanel.getNotificationLabel().getText())
        .isEqualTo("To view your buckets select a Cloud Project.");
  }

  @Test
  public void testNotificationLabel_emptyProjectSelection() {
    bucketPanel.getProjectSelector().setText("some-project");
    bucketPanel.getProjectSelector().setText("");

    assertTrue(bucketPanel.getNotificationPanel().isVisible());
    assertFalse(bucketPanel.getBucketListPanel().isVisible());

    assertThat(bucketPanel.getNotificationLabel().getText())
        .isEqualTo("To view your buckets select a Cloud Project.");
  }

  @Test
  public void testNotificationLabel_nonExistentProject() {
    bucketPanel.getProjectSelector().setText("some-project");

    assertTrue(bucketPanel.getNotificationPanel().isVisible());
    assertFalse(bucketPanel.getBucketListPanel().isVisible());

    assertThat(bucketPanel.getNotificationLabel().getText())
        .isEqualTo("Could not load buckets for selected project.");
  }
}