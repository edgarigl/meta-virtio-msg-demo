FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE:qemuarm64 = ".*"

SRC_URI:append:qemuarm64 = " \
    file://defconfig \
"

#KBUILD_DEFCONFIG:qemuarm64 ?= "xilinx_defconfig"

KERNEL_FEATURES:append:qemuarm64 = "${@bb.utils.contains('DISTRO_FEATURES', 'xen', ' features/xen/xen.scc', '', d)}"

# Don't install the kernel into the rootfs
#RRECOMMENDS:${KERNEL_PACKAGE_NAME}-base = ""
