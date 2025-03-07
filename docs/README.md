# meta-virtio-msg-demo

This layer includes the necessary parts to build a virtio-msg demo on AMD/Xilinx hardware.

## Dependencies

This layer depends on:

        URI: https://git.yoctoproject.org/poky
        layers: meta, meta-poky
        branch: scarthgap

        URI: https://git.openembedded.org/meta-openembedded
        layers: meta-oe
        branch: scarthgap

        URI: https://git.yoctoproject.org/meta-arm
        layers: meta-arm, meta-arm-toolchain
        branch: scarthgap

        URI: http://git.yoctoproject.org/git/meta-virtualization
        layers: meta-virtualization
        branch: scarthgap

        URI: https://github.com/Xilinx/meta-xilinx.git
        layers: meta-xilinx-core, meta-xilinx-standalone, meta-xilinx-bsp, meta-xilinx-virtualization
        branch: scarthgap

        URI: https://github.com/Xilinx/meta-openamp.git
        layers: meta-openamp
        branch: scarthgap
