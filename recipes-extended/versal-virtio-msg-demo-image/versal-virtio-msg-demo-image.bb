require recipes-extended/images/xen-image-minimal.bb

DESCRIPTION = "Versal Image to demonstrate virtio-msg at Embedded World."

LICENSE = "MIT"

#IMAGE_FEATURES:append = "dev-pkgs tools-sdk tools-debug tools-profile"

# Enable a self-hosted GCC on the target
#IMAGE_FEATURES:append = " tools-sdk"

# Debug tweaks
IMAGE_FEATURES:append = " debug-tweaks"

# For devtool to work without hassle
IMAGE_FEATURES:append = " allow-root-login"

IMAGE_INSTALL:append = " sudo"
IMAGE_INSTALL:append = " vim"

IMAGE_INSTALL:append = " kernel-modules kernel-module-uio-nc-mem"
IMAGE_INSTALL:append = " pci-flr-monitor"
IMAGE_INSTALL:append = " versal-virtio-msg-net-backend"

# Network setup
IMAGE_INSTALL:append = " openssh ssh-pregen-hostkeys"

IMAGE_INSTALL:append = " ethtool bridge-utils pciutils"
IMAGE_INSTALL:append = " devmem2 pcimem"

# We want upstream QEMU + virtio-msg patches (not Xilinx QEMU).
DEFAULT_XILINX_QEMU:aarch64 = "qemu"
QEMU_TARGETS = "aarch64"
IMAGE_INSTALL:append = " qemu"

# Debugging tools
IMAGE_INSTALL:append = " gdb strace ltrace tcf-agent"

# Frameworks
IMAGE_INSTALL:append = " libmetal-xlnx"

# Benchmarking apps
IMAGE_INSTALL:append = " memtester iperf3"
