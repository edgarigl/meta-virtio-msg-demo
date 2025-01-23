SUMMARY = "Run script for the virtio-msg-net backend on Versal."
SECTION = "base"
DESCRIPTION = "Run script for the virtio-msg-net backend on Versal."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=17418b62e96bdb68f14d9a24496dfab3"

SRC_URI = "file://run-versal-virtio-msg-net-backend.sh \
           file://LICENSE \
           "

S = "${WORKDIR}"

FILES:${PN} += "/usr/bin/run-versal-virtio-msg-net-backend.sh"

do_install () {
        install -d ${D}/usr/bin
        install -m 755 ${S}/run-versal-virtio-msg-net-backend.sh ${D}/usr/bin
}
