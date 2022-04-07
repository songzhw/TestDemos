#!/bin/bash

adb shell am start -W -a android.intent.action.VIEW -d "$1" ca.six.demo.utest2

# 使用教程:  ./testDeepLink.sh "six://account"