package com.saathi.features.screens;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0003J(\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001e\u0010\r\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/saathi/features/screens/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "MainScreen", "", "TabBarIconView", "isSelected", "", "selectedIcon", "Landroidx/compose/ui/graphics/painter/Painter;", "unselectedIcon", "title", "", "TabView", "tabBarItems", "", "Lcom/saathi/features/TabBarItem;", "navController", "Landroidx/navigation/NavController;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "features_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class MainActivity extends androidx.activity.ComponentActivity {
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    @android.annotation.SuppressLint(value = {"UnusedMaterial3ScaffoldPaddingParameter"})
    private final void MainScreen() {
    }
    
    @androidx.compose.runtime.Composable
    public final void TabView(@org.jetbrains.annotations.NotNull
    java.util.List<com.saathi.features.TabBarItem> tabBarItems, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable
    public final void TabBarIconView(boolean isSelected, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.graphics.painter.Painter selectedIcon, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.graphics.painter.Painter unselectedIcon, @org.jetbrains.annotations.NotNull
    java.lang.String title) {
    }
}