#!/bin/sh

# "c:/workhome/usr/src/study.home/AlgorithmStudy/test/TopCoder/SRM637_DIV2"
v_full_path_to_test_dir=$1
v_testcases=$2 # a space separater
v_test_name=`echo ${v_full_path_to_test_dir} | sed 's/.*\///g'`

if [ ! -d ${v_full_path_to_test_dir} ];then
  mkdir -p ${v_full_path_to_test_dir}
fi

for p_number in `echo "${v_testcases}"`
do

  for i in {1..5}
  do
  
    if [ ! -e "${v_full_path_to_test_dir}/${v_test_name}-${p_number}-case${i}.txt" ]; then
      touch "${v_full_path_to_test_dir}/${v_test_name}-${p_number}-case${i}.txt"
    fi
  
    if [ ! -e "${v_full_path_to_test_dir}/${v_test_name}-${p_number}-case${i}.answer.txt" ]; then
      touch "${v_full_path_to_test_dir}/${v_test_name}-${p_number}-case${i}.answer.txt"
    fi
  done

done
