<template>
  <v-form style="background-color: pink">
    <v-row>
      <v-col>
        <v-autocomplete
          v-model="selected"
          :items="['Trevor Handsen', 'Alex Nelson']"
          label="시도"
          full-width
          hide-details
          hide-no-data
          hide-selected
          single-line
        ></v-autocomplete>
      </v-col>
      <v-col>
        <v-autocomplete
          v-model="selected"
          :items="['Trevor Handsen', 'Alex Nelson']"
          label="군구"
          full-width
          hide-details
          hide-no-data
          hide-selected
          single-line
        ></v-autocomplete>
      </v-col>
    </v-row>

    <v-divider></v-divider>
    <v-text-field
      placeholder="제목을 입력하세요"
      single-line
      full-width
      hide-details
    ></v-text-field>
    <v-divider></v-divider>
    <v-textarea
      placeholder="내용을 입력하세요"
      v-model="title"
      label="Message"
      counter
      full-width
      single-line
    ></v-textarea>
  </v-form>
</template>

<script>
export default {
  name: "BoardWrite",
};
</script>

<style>
</style>