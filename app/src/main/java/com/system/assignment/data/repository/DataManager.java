package com.system.assignment.data.repository;

import com.system.assignment.data.api.ApiHelper;
import com.system.assignment.data.local.DatabaseHelper;
import com.system.assignment.data.shared.PreferencesHelper;

public interface DataManager extends DatabaseHelper, PreferencesHelper, ApiHelper {

}