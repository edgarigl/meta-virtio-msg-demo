SUMMARY = "Run script for the virtio-msg-net backend on Versal."
DESCRIPTION = "Run script for the virtio-msg-net backend on Versal."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=17418b62e96bdb68f14d9a24496dfab3"

inherit deploy

SRC_URI = "file://BOOT.BIN \
           file://LICENSE \
           "

S = "${WORKDIR}"

PROVIDES = "virtual/boot-bin"
DEPENDS += "${UBOOT_BOOT_SCRIPT}"

FILES:${PN} += "/boot/BOOT.bin"

BOOTBIN_BASE_NAME ?= "BOOT-${MACHINE}${IMAGE_VERSION_SUFFIX}"

do_compile:append:versal() {
    dd if=/dev/zero bs=256M count=1  > ${B}/qemu-${QEMU_FLASH_TYPE}.bin
    dd if=${S}/BOOT.BIN of=${B}/qemu-${QEMU_FLASH_TYPE}.bin bs=1 seek=0 conv=notrunc
    dd if=${DEPLOY_DIR_IMAGE}/boot.scr of=${B}/qemu-${QEMU_FLASH_TYPE}.bin bs=1 seek=66584576 conv=notrunc
}

do_deploy() {
    install -d ${DEPLOYDIR}
    install -m 0644 ${S}/BOOT.BIN ${DEPLOYDIR}/${BOOTBIN_BASE_NAME}.bin
    ln -sf ${BOOTBIN_BASE_NAME}.bin ${DEPLOYDIR}/BOOT-${MACHINE}.bin
    ln -sf ${BOOTBIN_BASE_NAME}.bin ${DEPLOYDIR}/boot.bin
}

do_install () {
        install -d ${D}/boot
        install -m 0644 ${S}/BOOT.BIN ${D}/boot/BOOT.bin
}
