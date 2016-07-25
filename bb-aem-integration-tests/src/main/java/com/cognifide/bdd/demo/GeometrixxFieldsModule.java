/*
 * Copyright 2016 Cognifide Ltd..
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
package com.cognifide.bdd.demo;

import com.cognifide.bdd.demo.po.touchui.dialog.text.FontFormat;
import com.cognifide.bdd.demo.po.touchui.components.text.dialog.panel.JustifyDialogPanel;
import com.cognifide.bdd.demo.po.touchui.components.text.dialog.panel.ListDialogPanel;
import com.cognifide.qa.bb.aem.pageobjects.touchui.dialogfields.DialogField;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class GeometrixxFieldsModule extends AbstractModule {

  @Override
  protected void configure() {
    Multibinder<DialogField> fieldsBinder = Multibinder.newSetBinder(binder(), DialogField.class);
    fieldsBinder.addBinding().to(FontFormat.class);
    fieldsBinder.addBinding().to(JustifyDialogPanel.class);
    fieldsBinder.addBinding().to(ListDialogPanel.class);
  }
}