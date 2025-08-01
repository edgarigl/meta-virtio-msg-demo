FILESEXTRAPATHS:prepend := "${THISDIR}/qemu:"

# Generate patch with qemu/scripts/create-patch-for-za-sdk.sh
SRC_URI:append = "file://virtio-msg.patch"

# Fixup what meta-xilinx breaks
PACKAGESPLITFUNCS =+ "split_qemu_packages_org"
ERROR_QA:remove = "patch-status"

python split_qemu_packages_org () {
    archdir = d.expand('${bindir}/')
    subpackages = do_split_packages(d, archdir, r'^qemu-system-(.*)$', '${PN}-system-%s', 'QEMU full system emulation binaries(%s)' , prepend=True, extra_depends='${PN}-common')

    subpackages += do_split_packages(d, archdir, r'^qemu-((?!system|edid|ga|img|io|nbd|pr-helper|storage-daemon).*)$', '${PN}-user-%s', 'QEMU full user emulation binaries(%s)' , prepend=True, extra_depends='${PN}-common')
    if subpackages:
        d.appendVar('RDEPENDS:' + d.getVar('PN'), ' ' + ' '.join(subpackages))
    mipspackage = d.getVar('PN') + "-user-mips"
    if mipspackage in ' '.join(subpackages):
        d.appendVar('RDEPENDS:' + mipspackage, ' ' + d.getVar("MLPREFIX") + 'bash')
}
