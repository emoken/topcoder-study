#!/bin/sh

#-------------------------------------------
# Sample command:
# 
# Ken@Ken-PC ~
# $ cd "C:\workhome\usr\src\study.home\AlgorithmStudy\test\TopCoder\SRM641_DIV2"
# Ken@Ken-PC ~/usr/src/study.home/AlgorithmStudy/test/tools
# $ /bin/sh create_test_case_in_java.sh "c:/workhome/usr/src/study.home/AlgorithmStudy/test/TopCoder/SRM641_DIV2" 250 BuyingTshirts meet
#
#-------------------------------------------


FL_TEST_CASE_TEMPLATE="TestCaseClassTemplate.txt"
fl_tmp="tmp.tmp"

v_full_path_to_test_dir=$1 # "c:/workhome/usr/src/study.home/AlgorithmStudy/test/TopCoder/SRM146_DIV2"
v_test_name=`echo ${v_full_path_to_test_dir} | sed 's/.*\///g'`  # "SRM146_DIV2"
v_problem_num=$2 # "1000"
v_class_name=$3 # "BridgeCrossing"
v_method_name=$4 # "minTime"

# validation
if [ ! -e ${FL_TEST_CASE_TEMPLATE} ];then
  echo "file doesn't exist in [${FL_TEST_CASE_TEMPLATE}]"
  exit;
fi

# main
cat ${FL_TEST_CASE_TEMPLATE} | sed "s/<TEST_NAME>/${v_test_name}/g" | sed "s/<PROBLEM_NUMBER>/${v_problem_num}/g" | sed "s/<CLASS_NAME>/${v_class_name}/g" | sed "s/<METHOD_NAME>/${v_method_name}/g" > $fl_tmp

mv $fl_tmp "${v_full_path_to_test_dir}/${v_class_name}Test.java"
