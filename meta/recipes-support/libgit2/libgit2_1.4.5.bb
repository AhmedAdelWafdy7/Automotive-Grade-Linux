SUMMARY = "the Git linkable library"
HOMEPAGE = "http://libgit2.github.com/"
LICENSE = "GPL-2.0-with-GCC-exception & MIT & OpenSSL"
LIC_FILES_CHKSUM = "file://COPYING;md5=e5a9227de4cb6afb5d35ed7b0fdf480d"

DEPENDS = "curl openssl zlib libssh2 libgcrypt libpcre2"

SRC_URI = "git://github.com/libgit2/libgit2.git;branch=maint/v1.4;protocol=https \
           file://CVE-2024-24575.patch \
           file://CVE-2024-24577.patch \
           "
SRCREV = "cd6f679af401eda1f172402006ef8265f8bd58ea"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "\
    -DBUILD_CLAR=OFF \
    -DCMAKE_BUILD_TYPE=RelWithDebInfo \
    -DLIB_INSTALL_DIR=${libdir} \
    -DREGEX_BACKEND='pcre2' \
"

BBCLASSEXTEND = "native"
