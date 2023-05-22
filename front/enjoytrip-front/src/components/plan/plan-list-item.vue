<template>
  <div>
    <v-card class="ma-4 md-12" width="100vh" height="auto">
      <v-row>
        <v-col cols="3">
          <v-list-item>
            {{ planInfo.image }}
          </v-list-item>
        </v-col>
        <v-col>
          <v-list>
            <v-list-item>
              <v-row>
                <div class="primary rounded-pill px-3 py-1">
                  <span>{{planInfo.startDate}}</span>
                  <span class="mx-3">-</span>
                  <span>{{planInfo.endDate}}</span>
                </div>
              </v-row>
            </v-list-item>
            <v-list-item >
              <span class="text-h4">
                {{planInfo.planTitle}}
              </span></v-list-item>
            <v-list-item>
              <span class="pr-4">
                <v-icon>mdi-account-multiple</v-icon>
                <span class="pl-1">{{ planInfo.userNickname }}</span>
                <span class="pl-1" v-for="(partner, index) in planInfo.partner" :key="index" >{{ partner.nickname }}</span>
              </span>
            </v-list-item>
          </v-list>
        </v-col>
      </v-row>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "PlanListItem",
  props: ["planInfo"]
  ,
}
</script>

<style>

</style>