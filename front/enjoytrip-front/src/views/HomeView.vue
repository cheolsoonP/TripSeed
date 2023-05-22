<template>
<div width="100%">
  <home-banner />
  <home-content />
</div>
</template>

<script>
import HomeBanner from '@/components/home/home-banner.vue'
import HomeContent from '@/components/home/home-content.vue'

  export default {
    name: 'HomeView',

    components: {
      HomeBanner, HomeContent,
    },
  }
</script>
