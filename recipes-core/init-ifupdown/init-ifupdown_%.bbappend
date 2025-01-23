FILESEXTRAPATHS:append := "${THISDIR}/files:"

SRC_URI:append = " file://interfaces-versal file://pre-up-xenbr0"

do_install:append:versal-generic () {
        install -m 0644 ${WORKDIR}/interfaces-versal ${D}${sysconfdir}/network/interfaces
        install -m 755 ${WORKDIR}/pre-up-xenbr0 ${D}${sysconfdir}/network/if-pre-up.d/xenbr0
}
