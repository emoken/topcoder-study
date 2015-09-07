#!/bin/sh

# ------------------------------------------------------------------------
# Usage
#
# $ /bin/sh runner_create_test_program_template.sh "SRM219_DIV1"
#
# ------------------------------------------------------------------------

SRM_ID=$1 # SRM646_DIV2
DIR_TEST_PACKAGE="c:/workhome/usr/src/study.home/AlgorithmStudy/src/test/java/TopCoder/${SRM_ID}"
DIR_SRC_PACKAGE="c:/workhome/usr/src/study.home/AlgorithmStudy/src/main/java/TopCoder/${SRM_ID}"

mkdir -p ${DIR_TEST_PACKAGE}
mkdir -p ${DIR_SRC_PACKAGE}

/bin/sh create_test_case_in_java.sh ${DIR_TEST_PACKAGE} 250 SampleProgram250 sampleMethod
/bin/sh create_test_case_in_java.sh  ${DIR_TEST_PACKAGE} 500 SampleProgram500 sampleMethod
/bin/sh create_test_case_in_java.sh  ${DIR_TEST_PACKAGE} 1000 SampleProgram1000 sampleMethod
/bin/sh create_test_data.sh  ${DIR_TEST_PACKAGE} 250
/bin/sh create_test_data.sh  ${DIR_TEST_PACKAGE} 500
/bin/sh create_test_data.sh  ${DIR_TEST_PACKAGE} 1000

##
echo --------------------------------------
echo " run result "
echo --------------------------------------
ls -ld ${DIR_TEST_PACKAGE}
ls -l  ${DIR_TEST_PACKAGE}

ls -ld ${DIR_SRC_PACKAGE}
ls -l  ${DIR_SRC_PACKAGE}
