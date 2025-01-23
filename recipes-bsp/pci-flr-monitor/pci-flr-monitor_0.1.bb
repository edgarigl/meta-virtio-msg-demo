SUMMARY = "Init script to launch pci-flr-monitor"
SECTION = "base"
DESCRIPTION = "Service to monitor for PCI FLR's and reconfigure DMA windows."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=17418b62e96bdb68f14d9a24496dfab3"

SRC_URI = "file://pci-flr-monitor.sh \
	   file://pci-flr-monitor \
	   file://LICENSE \
	   "

S = "${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "pci-flr-monitor"
INITSCRIPT_PARAMS = "start 20 3 5 . stop 90 0 1 2 6 ."

do_install () {
	install -d ${D}${sysconfdir}/init.d
	cat ${WORKDIR}/pci-flr-monitor | \
	  sed -e 's,/etc,${sysconfdir},g' \
	      -e 's,/usr/sbin,${sbindir},g' \
	      -e 's,/var,${localstatedir},g' \
	      -e 's,/usr/bin,${bindir},g' \
	      -e 's,/usr,${prefix},g' > ${D}${sysconfdir}/init.d/pci-flr-monitor
	chmod a+x ${D}${sysconfdir}/init.d/pci-flr-monitor

	install -d ${D}${sbindir}
	install -m 0755 ${WORKDIR}/pci-flr-monitor.sh ${D}${sbindir}/
}

RDEPENDS:${PN} = "initscripts"

CONFFILES:${PN} += "${sysconfdir}/init.d/pci-flr-monitor"
